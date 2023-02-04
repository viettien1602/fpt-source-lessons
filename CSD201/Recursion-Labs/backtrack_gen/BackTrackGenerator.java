package backtrack_gen;

import java.util.Collection;
import java.util.ArrayList;

public class BackTrackGenerator {
    protected int noOfSet = 0;
    ArrayList<IntMinMaxSet> iDomains = new ArrayList<>();
    Configuration curConfig = new Configuration();
    boolean initiated = false; //whether the generator is initiated of not

    //Add a domain specified by min and max values: [min, max]
    public void addDomain(int min, int max) {
        IntMinMaxSet aSet = new IntMinMaxSet(min, max);
        iDomains.add(aSet);
        noOfSet++;
    }
    //Add a domain specified by a list of real objects
    public void addDomain(Collection list) {
        IntMinMaxSet aSet = new IntMinMaxSet(list);
        iDomains.add(aSet);
        noOfSet++;
    }

    //Initiate the generator
    public void init() {
        curConfig.clear();
        for (int i = 0; i < noOfSet; i++) {
            IntMinMaxSet set = iDomains.get(i);
            set.reset();
            curConfig.add(set.nextValue());
        }
        initiated = true;
    }

    //reset the genarator
    public void reset() {
        initiated = false;
    }
    //check whether the generator is in the last configuration
    private boolean isLastConfiguration() {
        for (int i = 0; i < noOfSet; i++) {
            if (!iDomains.get(i).isLastValue()) return false;
        }
        return true;
    }
    //get a copy of the current configuration
    //the curConfig of the generator must be reserved
    private Configuration copyConfiguration() {
        Configuration result = new Configuration(curConfig.size());
        for (int i = 0; i < curConfig.size(); i++) {
            result.add(curConfig.get(i).intValue());
        }
        return result;
    }
    public Configuration getFirstConfig() {
        init();
        return copyConfiguration();
    }
    //get the next configuration from the current configuration
    public Configuration nextConfiguration() {
        if (!initiated || isLastConfiguration()) return null;
        int lastIndex = noOfSet - 1;
        while (lastIndex >= 0 && iDomains.get(lastIndex).isLastValue())
            lastIndex--;
        int nextValue = iDomains.get(lastIndex).nextValue();
        curConfig.update(lastIndex, nextValue);
        if (lastIndex >= 0) {
            for (int i = lastIndex + 1; i < noOfSet; i++) {
                IntMinMaxSet aSet = iDomains.get(i);
                aSet.reset();
                curConfig.update(i, aSet.nextValue());
            }
        }
        return copyConfiguration();
    }
}
