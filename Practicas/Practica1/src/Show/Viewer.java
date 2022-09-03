import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Viewer implements Observer {

    private String name;

    private String history;

    private String support;

    private Ring watch;

    private String move;

    public Viewer(String name, Ring watch, String support) {
        this.name = name;
        this.watch = watch;
        this.history = "";
        this.support = support;
        this.move = "";
    }

    @Override
    public void update() {
        this.move = watch.getMove();
        this.history += move + "\n";
    }

    public String getName() {
        return name;
    }
      
    public String getHistory() {
        return history;
    }
    
    public String getSupport() {
        return support;
    }

    public void finish(String winner) {
        if (winner.equals(support)) {
            this.history += "Felicidades, el peleador que apoyaste gano!";
        } else {
            this.history += "Lo siento, el peleador que apoyaste perdio!";
        }
    }

    public void leave() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(name + "History.txt"));
        bw.write(history);
        bw.flush();
        bw.close();
    }
}
