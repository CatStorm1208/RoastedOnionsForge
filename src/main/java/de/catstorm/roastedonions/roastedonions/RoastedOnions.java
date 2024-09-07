package de.catstorm.roastedonions.roastedonions;

import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RoastedOnions.MODID)
public class RoastedOnions {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "roastedonions";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "roastedonions" namespace
    // Create a Deferred Register to hold Items which will all be registered under the "roastedonions" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespac

    public static final RegistryObject<Item> roastedonion = ITEMS.register("roastedonion",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(3.62f/20).build())));

    public static final RegistryObject<Item> blue_spandauer = ITEMS.register("blue_spandauer",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> red_spandauer = ITEMS.register("red_spandauer",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> golden_berries = ITEMS.register("golden_berries",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(11).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> raw_sausage = ITEMS.register("raw_sausage",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(3.62f/20).build())));

    public static final RegistryObject<Item> cooked_sausage = ITEMS.register("cooked_sausage",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(7.35f/20).build())));

    public static final RegistryObject<Item> hotdog = ITEMS.register("hotdog",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(9f/20).build())));

    public static final RegistryObject<Item> hotdog_with_ketchup = ITEMS.register("hotdog_with_ketchup",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(8).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> pig_fat = ITEMS.register("pig_fat",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(3.000001f/20).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 4), 0.95f).build())));

    public static final RegistryObject<Item> pork_rind = ITEMS.register("pork_rind",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.694201f/20).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 4), 0.69f).build())));

    public static final RegistryObject<Item> uncooked_klejner = ITEMS.register("uncooked_klejner",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> klejner = ITEMS.register("klejner",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationMod(4.111111f/20).build())));

    public static final RegistryObject<Item> salmon_fillet = ITEMS.register("salmon_fillet",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(1).saturationMod(1f/20).build())));

    public static final RegistryObject<Item> smoked_salmon = ITEMS.register("smoked_salmon",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationMod(4f/20).build())));

    public static final RegistryObject<Item> smorrebrod = ITEMS.register("smorrebrod",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(9).saturationMod(10f/20).build())));

    public static final RegistryObject<Item> roe = ITEMS.register("roe",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.4f/20).build())));

    public static final RegistryObject<Item> bread_with_roe = ITEMS.register("bread_with_roe",
        () -> new Item(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(7).saturationMod(7f/20).build())));

    public RoastedOnions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::buildContents);

        // Register the Deferred Register to the mod event bus so blocks get registered
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(roastedonion);
            event.accept(blue_spandauer);
            event.accept(red_spandauer);
            event.accept(golden_berries);
            event.accept(raw_sausage);
            event.accept(cooked_sausage);
            event.accept(hotdog);
            event.accept(hotdog_with_ketchup);
            event.accept(pig_fat);
            event.accept(pork_rind);
            event.accept(uncooked_klejner);
            event.accept(klejner);
            event.accept(salmon_fillet);
            event.accept(smoked_salmon);
            event.accept(smorrebrod);
            event.accept(roe);
            event.accept(bread_with_roe);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }
}
