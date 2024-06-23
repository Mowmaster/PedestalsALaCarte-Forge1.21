package com.mowmaster.pedestalsutil.Api.Coloring;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public interface IColorable
{
    public static enum DefaultColors {
        DEFAULT,
        WHITE,
        LIGHT_GRAY,
        GRAY,
        BLACK,
        RED,
        ORANGE,
        YELLOW,
        LIME,
        GREEN,
        LIGHT_BLUE,
        CYAN,
        BLUE,
        PURPLE,
        MAGENTA,
        PINK,
        BROWN;

        private DefaultColors() { }

        public boolean colorDefault() { return this == DEFAULT; }
        public boolean colorWhite() { return this == WHITE; }
        public boolean colorLightGray() { return this == LIGHT_GRAY; }
        public boolean colorGray() { return this == GRAY; }
        public boolean colorBlack() { return this == BLACK; }
        public boolean colorRed() { return this == RED; }
        public boolean colorOrange() { return this == ORANGE; }
        public boolean colorYellow() { return this == YELLOW; }
        public boolean colorLime() { return this == LIME; }
        public boolean colorGreen() { return this == GREEN; }
        public boolean colorLightBlue() { return this == LIGHT_BLUE; }
        public boolean colorCyan() { return this == CYAN; }
        public boolean colorBlue() { return this == BLUE; }
        public boolean colorPurple() { return this == PURPLE; }
        public boolean colorMagenta() { return this == MAGENTA; }
        public boolean colorPink() { return this == PINK; }
        public boolean colorBrown() { return this == BROWN; }



        // These are needed for saving stuff to NBT and NOTHING ELSE
        public int intColor()
        {
            switch (this)
            {
                case WHITE: return 16777215;
                case LIGHT_GRAY: return 11184810;
                case GRAY: return 2763306;
                case BLACK: return 2763306;
                case RED: return 11141120;
                case ORANGE: return 16755200;
                case YELLOW: return 16776960;
                case LIME: return 5614080;
                case GREEN: return 5614080;
                case LIGHT_BLUE: return 43775;
                case CYAN: return 43690;
                case BLUE: return 5592575;
                case PURPLE: return 11141375;
                case MAGENTA: return 16733695;
                case PINK: return 16733610;
                case BROWN: return 5592320;
                default: return 16777215;
            }
        }

        public void serializeColor(ItemStack stackIn, int color)
        {
            CompoundTag nbt = new CompoundTag();
            if(stackIn.hasTag()) nbt = stackIn.getTag();

            nbt.putInt(MODID + "_enum_itemtransfermode", modeToSet.ordinal());
            stackIn.setTag(nbt);
        }
        
        public void serializeColorHex(ItemStack stackIn, int red, int green, int blue)
        {
            CompoundTag nbt = new CompoundTag();
            if(stackIn.hasTag()) nbt = stackIn.getTag();

            nbt.putInt(MODID + "_enum_itemtransfermode", modeToSet.ordinal());
            stackIn.setTag(nbt);
        }



        public static int getColorFromStack(ItemStack stackIn)
        {
            if(stackIn.hasTag())
            {
                if(stackIn.getTag().contains(MODID + "_enum_itemtransfermode"))
                {
                    return stackIn.getTag().getInt(MODID + "_enum_itemtransfermode");
                }
            }

            return 0;
        }

    }
}
