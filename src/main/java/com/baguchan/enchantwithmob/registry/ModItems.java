package com.baguchan.enchantwithmob.registry;

import com.baguchan.enchantwithmob.EnchantWithMob;
import com.baguchan.enchantwithmob.item.EnchantersBookItem;
import com.baguchan.enchantwithmob.item.MobEnchantBookItem;
import com.baguchan.enchantwithmob.item.MobUnEnchantBookItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnchantWithMob.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final Item ENCHANTERS_BOOK = new EnchantersBookItem((new Item.Properties()).stacksTo(1).durability(64).tab(CreativeModeTab.TAB_MISC));
    public static final Item MOB_ENCHANT_BOOK = new MobEnchantBookItem((new Item.Properties()).stacksTo(1).durability(5).tab(CreativeModeTab.TAB_MISC));
    public static final Item MOB_UNENCHANT_BOOK = new MobUnEnchantBookItem((new Item.Properties()).stacksTo(1).durability(5).tab(CreativeModeTab.TAB_MISC));
    public static final Item ENCHANTER_SPAWNEGG = new SpawnEggItem(ModEntities.ENCHANTER, 9804699, 0x81052d, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC));

    public static void register(RegistryEvent.Register<Item> registry, Item item, String id) {
        item.setRegistryName(new ResourceLocation(EnchantWithMob.MODID, id));

        registry.getRegistry().register(item);
    }

    public static void register(RegistryEvent.Register<Item> registry, Item item) {

        if (item instanceof BlockItem && item.getRegistryName() == null) {
            item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
        }

        registry.getRegistry().register(item);
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> registry) {
        register(registry, ENCHANTERS_BOOK, "enchanters_book");
        register(registry, MOB_ENCHANT_BOOK, "mob_enchant_book");
        register(registry, MOB_UNENCHANT_BOOK, "mob_unenchant_book");
        register(registry, ENCHANTER_SPAWNEGG, "enchanter_spawn_egg");
    }

}
