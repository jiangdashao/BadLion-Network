package net.badlion.shinyinventory.gui.interfaces;

import net.badlion.shinyinventory.gui.Interface;
import net.badlion.shinyinventory.gui.SimpleInterfaceHolder;
import net.badlion.shinyinventory.gui.buttons.Button;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class ChestInterface extends Interface {

    private int size;
    public Interface parent;
    private Inventory inventory;
    private String title;

    public ChestInterface(Player player, List<Button> buttons, int size, String title, Interface parent) {
        super(player, buttons);
        setSize(size);
        setTitle(title);
        setParent(parent);
        this.inventory = Bukkit.createInventory(new SimpleInterfaceHolder(inventory, this), getSize(), getTitle());
        //setInventory(new InterfaceInventory(this, inventory));
    }

    public void setSize(int size) {
        //If the size isn't a multiple of 9, round it to the nearest multiple of 9.
        if (size % 9 != 0) {
            setSize(9*(Math.round(size / 9)));
        } else {
            this.size = size;
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setTitle(String title) {
        int titleSize = 32;
        this.title = title.length() > titleSize ? title.substring(0, titleSize - 1) : title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setParent(Interface parent) {
        this.parent = parent;
    }

    public Interface getParent() {
        return this.parent;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

}
