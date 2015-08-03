package eu.comsode.unifiedviews.plugins.extractor.corrector;

import java.util.ArrayList;
import java.util.List;

import eu.comsode.unifiedviews.plugins.extractor.service.Compare;
import eu.comsode.unifiedviews.plugins.extractor.service.Transform;

public class Corrector {

    public String[] getArgs() {
        String[] args = {};
        return args;
    }

    public List<String> correct(List<String> row) {
        if (isHeader(row)) {
            return null;
        }
        List<String> newRow = new ArrayList<String>();
        for (String s : row) {
            newRow.add(s.trim());
        }
        if (newRow.get(1).isEmpty()) {
            newRow.remove(1);
        }
        newRow.set(3, Transform.numToZip(newRow.get(3)));
        newRow.add(isConsistent(newRow) ? "correct" : "mismatch");
        return newRow;
    }

    private boolean isConsistent(List<String> row) {
        if (row.size() != 7) {
            return false;
        }

        if (!Compare.isZIP(row.get(3))) {
            return false;
        }
        if (!Compare.isDouble(row.get(5))) {
            return false;
        }
        return true;
    }

    public boolean isHeader(List<String> row) {
        if (row.get(0).equalsIgnoreCase("Názov")) {
            return true;
        }
        return false;
    }
}
