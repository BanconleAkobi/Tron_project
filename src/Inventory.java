import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Asset> assets;
    private int coins;

    public Inventory(int coins) {
        this.assets = new ArrayList<>();
        this.coins = coins;
    }

    public boolean addAsset(Asset asset) {
        if (coins >= asset.getPrice()) {
            assets.add(asset);
            coins -= asset.getPrice();
            System.out.println("Successful purchase: " + asset.getName());
            return true;
        } else {
            System.out.println("Less coins for a purchase  : " + asset.getName());
            return false;
        }
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
