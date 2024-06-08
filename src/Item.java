/*
Item (Abstract Class): (Optional)
o	Properties: id (unique identifier), name (item name)
o	Methods: getName(), getID() (abstract) - Enforces subclasses to implement their specific retrieval methods
 */

public abstract class Item {
    protected final int ID;
    private String name;
    private int itemCount = 1;

    public Item () {
        this.ID = itemCount;
        itemCount++;
    }

    public abstract String getName();    
    public abstract int getID();
}
