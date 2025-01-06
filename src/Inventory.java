import java.util.ArrayList;
import java.util.List;

//inventaire des assets.
public class Inventory {

    
    //array list pour les differents assets(moto + trail)
    private List<Asset> assets = new ArrayList<>();

    //methode d'ajout d'un asset dans l'inventaire.
    public void addAsset(Asset asset) {
        assets.add(asset);
    }

    public List<Asset> getAssets() {
        return assets;
    }


}
