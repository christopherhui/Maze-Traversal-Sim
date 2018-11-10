package model;

import exceptions.IllegalCharacterException;
import model.blocks.*;

public class BlockFactory {

    public SpecializedBlock createEmptyBlock() {
        return new EmptySpace();
    }

    public SpecializedBlock makeBlock(String s) throws IllegalCharacterException {
        if (s.equals("O")) {
            return new EmptySpace();
        }
        else if(s.equals("E")) {
            return new End();
        }
        else if(s.equals("F")) {
            return new Location();
        }
        else if(s.equals("S")) {
            return new Start();
        }
        else if(s.equals("V")) {
            return new Traversed();
        }
        else if(s.equals("W")) {
            return new Wall();
        }
        throw new IllegalCharacterException();
    }
}
