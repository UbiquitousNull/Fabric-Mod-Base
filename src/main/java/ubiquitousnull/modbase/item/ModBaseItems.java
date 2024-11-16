package ubiquitousnull.modbase.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ubiquitousnull.modbase.ModBase;

public class ModBaseItems {

    public static final Item MOD_ITEM = registerItem("mod_item", new Item(new FabricItemSettings()));

    private static void addItemsToItemTabGroup(FabricItemGroupEntries entries) {
        entries.add(MOD_ITEM);
    }

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ModBase.MOD_ID, name), item);
    }

    public static void registerModBaseItems() {
        ModBase.LOGGER.info("Registering Mod Items for: " + ModBase.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(ModBaseItems::addItemsToItemTabGroup);
    }
}
