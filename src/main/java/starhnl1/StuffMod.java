package starhnl1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import starhnl1.lists.BlockList;
import starhnl1.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
					ItemList.copper_ore = new ItemBlock(BlockList.copper_ore, new Item.Properties().group(Stuff)).setRegistryName(BlockList.copper_ore.getRegistryName()),
					ItemList.copper_block = new ItemBlock(BlockList.copper_block, new Item.Properties().group(Stuff)).setRegistryName(BlockList.copper_block.getRegistryName()),
					ItemList.copper_ingot = new Item(new Item.Properties().group(Stuff)).setRegistryName(location("copper_ingot"))
			);
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll
			(
					BlockList.copper_ore = 	new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f,3.0f).sound(SoundType.STONE)).setRegistryName(location("copper_ore")),
					BlockList.copper_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).sound(SoundType.METAL)).setRegistryName(location("copper_block"))
			);
			logger.info("Blocks registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}
