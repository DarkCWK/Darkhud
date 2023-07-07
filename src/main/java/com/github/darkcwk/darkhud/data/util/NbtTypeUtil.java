package com.github.darkcwk.darkhud.data.util;

import com.github.darkcwk.darkhud.data.common.NbtData;
import com.github.darkcwk.darkhud.data.common.NbtListData;

import net.minecraft.nbt.NbtByte;
import net.minecraft.nbt.NbtByteArray;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtDouble;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtFloat;
import net.minecraft.nbt.NbtInt;
import net.minecraft.nbt.NbtIntArray;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtLong;
import net.minecraft.nbt.NbtLongArray;
import net.minecraft.nbt.NbtShort;
import net.minecraft.nbt.NbtString;

public class NbtTypeUtil {
    public static Object toObject(NbtElement nbtElement){
        switch (nbtElement.getType()) {
            case NbtElement.END_TYPE: // 不应该有这个
                return null;
            case NbtElement.BYTE_TYPE:
                return ((NbtByte) nbtElement).byteValue();
            case NbtElement.SHORT_TYPE:
                return ((NbtShort) nbtElement).shortValue();
            case NbtElement.INT_TYPE:
                return ((NbtInt) nbtElement).intValue();
            case NbtElement.LONG_TYPE:
                return ((NbtLong) nbtElement).longValue();
            case NbtElement.FLOAT_TYPE:
                return ((NbtFloat) nbtElement).floatValue();
            case NbtElement.DOUBLE_TYPE:
                return ((NbtDouble) nbtElement).doubleValue();
            case NbtElement.BYTE_ARRAY_TYPE:
                return ((NbtByteArray) nbtElement).getByteArray();
            case NbtElement.STRING_TYPE:
                return ((NbtString) nbtElement).asString();
            case NbtElement.LIST_TYPE:
                NbtListData nbtListData = new NbtListData();
                nbtListData.update((NbtList) nbtElement);
                return nbtListData;
            case NbtElement.COMPOUND_TYPE:
                NbtData nbtData = new NbtData();
                nbtData.update((NbtCompound) nbtElement);
                return nbtData;
            case NbtElement.INT_ARRAY_TYPE:
                return ((NbtIntArray) nbtElement).getIntArray();
            case NbtElement.LONG_ARRAY_TYPE:
                return ((NbtLongArray) nbtElement).getLongArray();
            case NbtElement.NUMBER_TYPE:
                throw new UnsupportedOperationException("未支持 NUMBER_TYPE, 请提出 issue");
            default:
                throw new UnsupportedOperationException("未知类型, 请提出 issue");
        }
    }
}
