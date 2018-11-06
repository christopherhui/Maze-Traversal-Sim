package model.blocks;

import java.util.ArrayList;
import java.util.List;

public class AllBlocks extends SpecializedBlock {
    private List<SpecializedBlock> specializedBlocks;

    public AllBlocks() {
        this.specializedBlocks = new ArrayList<>();
    }

    public void addBlock(SpecializedBlock block) {
        if (!specializedBlocks.contains(block)) {
            specializedBlocks.add(block);
        }
    }

    public List<SpecializedBlock> getSpecializedBlocks() {
        return specializedBlocks;
    }

    @Override
    public String toString() {
        return null;
    }
}
