package com.github.darkcwk.darkhud.data.darkhud;

import com.github.darkcwk.darkhud.data.common.BlockData;
import com.github.darkcwk.darkhud.data.common.EntityData;
import com.github.darkcwk.darkhud.data.darkhud.player.ArmorData;
import com.github.darkcwk.darkhud.data.darkhud.player.HandData;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;

public class PlayerData {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    private BlockData targetedBlock;

    private EntityData targetedEntity;

    private HandData hand;

    private ArmorData armor;

    public BlockData getTargetedBlock() {
        return targetedBlock;
    }

    public EntityData getTargetedEntity() {
        return targetedEntity;
    }

    public HandData getHand() {
        return hand;
    }

    public ArmorData getArmor() {
        return armor;
    }

    public void update() {
        if (this.targetedBlock == null) {
            this.targetedBlock = new BlockData();
        }
        HitResult hitResult = client.cameraEntity.raycast(client.interactionManager.getReachDistance(), 0, false);
        if (hitResult.getType() == Type.BLOCK) {
            this.targetedBlock.update(client.world.getBlockState(((BlockHitResult) hitResult).getBlockPos()));
        } else {
            this.targetedBlock.update(null);
        }

        if (this.targetedEntity == null) {
            this.targetedEntity = new EntityData();
        }
        this.targetedEntity.update(client.targetedEntity);

        if (hand == null) {
            this.hand = new HandData();
        }
        this.hand.update();

        if (armor == null) {
            this.armor = new ArmorData();
        }
        this.armor.update();
    }
}
