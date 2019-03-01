public class Begpack {

    private int maxWeight; // вместимость рюкзака

    // лучшие параметры "запаковки"
    private int bestPrice;
    private String bestStaff;
    private int bestWeight;


    public Begpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    // вспомогательный метод
    public void bestPacking(Staff[] staffs) {
        pushStaff(staffs, -1);
        System.out.println("Лучший выбор: " + bestStaff + "- стоимость: " + bestPrice + " вес: " +bestWeight);
    }


    // метод по запаковке
    public void pushStaff(Staff[] staffs, int excludedStaff) {
        int currentPrice = 0;
        int currentWeight = 0;
        String currentStaff = "";
        for (int i = 0; i < staffs.length; i++) {
            if (i != excludedStaff && maxWeight - (currentWeight + staffs[i].getWeight()) > 0) {
                currentWeight = currentWeight + staffs[i].getWeight();
                currentPrice = currentPrice + staffs[i].getPrice();
                currentStaff = currentStaff + staffs[i].getName() + " ";
            }
        }

        if (excludedStaff < staffs.length - 1) {
            checkBest(currentStaff, currentWeight, currentPrice);
            excludedStaff++;
            pushStaff(staffs, excludedStaff);
        } else {
            return;
        }
    }

    private void checkBest(String currentStaff, int currentWeight, int currentPrice) {
        if(currentPrice > bestPrice) {
            bestPrice = currentPrice;
            bestStaff = currentStaff;
            bestWeight = currentWeight;
        }
    }
}
