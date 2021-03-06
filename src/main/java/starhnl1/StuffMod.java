package starhnl1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import starhnl1.items.ItemCustomAxe;
import starhnl1.items.ItemCustomPickaxe;
import starhnl1.lists.ArmorMaterialList;
import starhnl1.lists.BlockList;
import starhnl1.lists.ItemList;
import starhnl1.lists.ToolMaterialList;
import starhnl1.world.OreGeneration;

@Mod("starhnl1") 
public class StuffMod 
{
	public static StuffMod instance;
	public static final String modid = "starhnl1";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup Stuff = new StuffModItemGroup();
	
	public StuffMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		logger.info("Setup Method Registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries Method Registered");
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					// Blocks
					ItemList.copper_ore = new ItemBlock(BlockList.copper_ore, new Item.Properties().group(Stuff)).setRegistryName(BlockList.copper_ore.getRegistryName()),
					ItemList.copper_block = new ItemBlock(BlockList.copper_block, new Item.Properties().group(Stuff)).setRegistryName(BlockList.copper_block.getRegistryName()),
					ItemList.titanium_ore = new ItemBlock(BlockList.titanium_ore, new Item.Properties().group(Stuff)).setRegistryName(BlockList.titanium_ore.getRegistryName()),
					ItemList.titanium_block = new ItemBlock(BlockList.titanium_block, new Item.Properties().group(Stuff)).setRegistryName(BlockList.titanium_block.getRegistryName()),
					ItemList.silver_ore = new ItemBlock(BlockList.silver_ore, new Item.Properties().group(Stuff)).setRegistryName(BlockList.silver_ore.getRegistryName()),
					ItemList.silver_block = new ItemBlock(BlockList.silver_block, new Item.Properties().group(Stuff)).setRegistryName(BlockList.silver_block.getRegistryName()),
					// Items
					ItemList.copper_ingot = new Item(new Item.Properties().group(Stuff)).setRegistryName(location("copper_ingot")),
					ItemList.copper_nugget = new Item(new Item.Properties().group(Stuff)).setRegistryName(location("copper_nugget")),
					ItemList.titanium_ingot = new Item(new Item.Properties().group(Stuff)).setRegistryName(location("titanium_ingot")),
					ItemList.silver_ingot = new Item(new Item.Properties().group(Stuff)).setRegistryName(location("silver_ingot")),
					// Tools
						// Copper
						ItemList.copper_axe = new ItemCustomAxe(ToolMaterialList.copper, 4.0f, -3.2f, new Item.Properties().group(Stuff)).setRegistryName(location("copper_axe")),
						ItemList.copper_hoe = new ItemHoe(ToolMaterialList.copper, -2.0f, new Item.Properties().group(Stuff)).setRegistryName(location("copper_hoe")),
						ItemList.copper_pickaxe = new ItemCustomPickaxe(ToolMaterialList.copper, -2, -2.8f, new Item.Properties().group(Stuff)).setRegistryName(location("copper_pickaxe")),
						ItemList.copper_shovel = new ItemSpade(ToolMaterialList.copper, -1.0f, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("copper_shovel")),
						ItemList.copper_sword = new ItemSword(ToolMaterialList.copper, 0, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("copper_sword")),
						// Silver
						ItemList.silver_axe = new ItemCustomAxe(ToolMaterialList.silver, 4.0f, -3.2f, new Item.Properties().group(Stuff)).setRegistryName(location("silver_axe")),
						ItemList.silver_hoe = new ItemHoe(ToolMaterialList.silver, -2.0f, new Item.Properties().group(Stuff)).setRegistryName(location("silver_hoe")),
						ItemList.silver_pickaxe = new ItemCustomPickaxe(ToolMaterialList.silver, -2, -2.8f, new Item.Properties().group(Stuff)).setRegistryName(location("silver_pickaxe")),
						ItemList.silver_shovel = new ItemSpade(ToolMaterialList.silver, -1.0f, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("silver_shovel")),
						ItemList.silver_sword = new ItemSword(ToolMaterialList.silver, 0, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("silver_sword")),
						// Titanium
						ItemList.titanium_axe = new ItemCustomAxe(ToolMaterialList.titanium, 4.0f, -3.2f, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_axe")),
						ItemList.titanium_hoe = new ItemHoe(ToolMaterialList.titanium, -2.0f, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_hoe")),
						ItemList.titanium_pickaxe = new ItemCustomPickaxe(ToolMaterialList.titanium, -2, -2.8f, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_pickaxe")),
						ItemList.titanium_shovel = new ItemSpade(ToolMaterialList.titanium, -1.0f, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_shovel")),
						ItemList.titanium_sword = new ItemSword(ToolMaterialList.titanium, 0, -2.4f, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_sword")),
					// Armor
						// Copper
						ItemList.copper_helmet = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.HEAD, new Item.Properties().group(Stuff)).setRegistryName(location("copper_helmet")),
						ItemList.copper_chestplate = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.CHEST, new Item.Properties().group(Stuff)).setRegistryName(location("copper_chestplate")),
						ItemList.copper_leggings = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.LEGS, new Item.Properties().group(Stuff)).setRegistryName(location("copper_leggings")),
						ItemList.copper_boots = new ItemArmor(ArmorMaterialList.copper, EntityEquipmentSlot.FEET, new Item.Properties().group(Stuff)).setRegistryName(location("copper_boots")),
						// Silver
						ItemList.silver_helmet = new ItemArmor(ArmorMaterialList.silver, EntityEquipmentSlot.HEAD, new Item.Properties().group(Stuff)).setRegistryName(location("silver_helmet")),
						ItemList.silver_chestplate = new ItemArmor(ArmorMaterialList.silver, EntityEquipmentSlot.CHEST, new Item.Properties().group(Stuff)).setRegistryName(location("silver_chestplate")),
						ItemList.silver_leggings = new ItemArmor(ArmorMaterialList.silver, EntityEquipmentSlot.LEGS, new Item.Properties().group(Stuff)).setRegistryName(location("silver_leggings")),
						ItemList.silver_boots = new ItemArmor(ArmorMaterialList.silver, EntityEquipmentSlot.FEET, new Item.Properties().group(Stuff)).setRegistryName(location("silver_boots")),			
						// Titanium
						ItemList.titanium_helmet = new ItemArmor(ArmorMaterialList.titanium, EntityEquipmentSlot.HEAD, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_helmet")),
						ItemList.titanium_chestplate = new ItemArmor(ArmorMaterialList.titanium, EntityEquipmentSlot.CHEST, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_chestplate")),
						ItemList.titanium_leggings = new ItemArmor(ArmorMaterialList.titanium, EntityEquipmentSlot.LEGS, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_leggings")),
						ItemList.titanium_boots = new ItemArmor(ArmorMaterialList.titanium, EntityEquipmentSlot.FEET, new Item.Properties().group(Stuff)).setRegistryName(location("titanium_boots")),
					// Food
					ItemList.green_apple = new ItemFood(4, 2.4f, false, new Item.Properties().group(Stuff)).setRegistryName(location("green_apple"))
					
			);
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					BlockList.copper_ore = 	 new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("copper_ore")),
					BlockList.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_block")),
					BlockList.titanium_ore =   new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("titanium_ore")),
					BlockList.titanium_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("titanium_block")),
					BlockList.silver_ore =   new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("silver_ore")),
					BlockList.silver_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("silver_block"))		
			);
			logger.info("Blocks registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
