package blocks;

public class Traversed extends SpecializedBlock {

    public Traversed() {
        backgroundColor = "Grey";
        status = 1;
    }

    @Override
    public String to_display() {
        return "V";
    }
}
