package pos.machine;

import java.util.ArrayList;
import java.util.List;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        return null;
    }

    public List<String> getValuesFromBarcode(List<String> barcodes) {
        List<ItemInfo> itemInfos = loadAllItemInfos();
        List<String> itemList = new ArrayList<>();

        //get name of what is in the cart using the barcodes
        for(int i=0; i<barcodes.size();i++){
            for(ItemInfo item: itemInfos) {
                if (item.getBarcode().equals(barcodes.get(i))) { //compare the barcode in ItemInfo and what is in the cart
                    itemList.add(item.getName()); //add the name of the item in the list
                }
            }
        }

        return itemList;
    }

    public int countQuantity(List<String> itemList, String currentItem) {
        int count = 0;

        for(String item: itemList){
            if(item.equals(currentItem)){
                count++;
            }
        }

        return count;
    }


    public int calculate(List<String> itemList) {
        return 0;
    }


    public String renderReceipt(List<String> itemList, int totalPrice) {
        return null;
    }


    public int calculateSubtotal(List<String> itemList) {

        return 0;
    }


    public int calculateTotal(List<String> itemList) {

        return 0;
    }

}
