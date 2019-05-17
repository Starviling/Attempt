package starhnl1.lists;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	copper("copper", 400, new int[] {1,3,4,2}, 25, ItemList.copper_ingot, "item.armor.equip_iron", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private int[] damageReductionAmounts;
	private Item repairItem;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		 this.name = name;
		 this.durability = durability;
		 this.damageReductionAmounts = damageReductionAmounts;
		 this.enchantability = enchantability;
		 this.repairItem = repairItem;
		 this.equipSound = equipSound;
		 this.toughness = toughness;
	}

	@Override
	public int getDamageReductionAmount(EntityEquipmentSlot slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EntityEquipmentSlot slot) 
	{
		return max_damage_array[slot.getIndex()]*this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return "starhnl1:" + this.name;  //if modid changes, change this
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	} 

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
}