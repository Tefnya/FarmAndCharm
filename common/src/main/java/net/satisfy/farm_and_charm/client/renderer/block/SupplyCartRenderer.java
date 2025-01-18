package net.satisfy.farm_and_charm.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.satisfy.farm_and_charm.client.model.SupplyCartModel;
import net.satisfy.farm_and_charm.core.entity.SupplyCartEntity;
import net.satisfy.farm_and_charm.core.util.FarmAndCharmIdentifier;
import org.jetbrains.annotations.NotNull;

public class SupplyCartRenderer extends EntityRenderer<SupplyCartEntity> {
    public static final ResourceLocation CART_TEXTURE = new FarmAndCharmIdentifier("textures/entity/supply_cart.png");
    private final SupplyCartModel<SupplyCartEntity> model;

    public SupplyCartRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SupplyCartModel<>(context.bakeLayer(SupplyCartModel.LAYER_LOCATION));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(SupplyCartEntity entity) {
        return CART_TEXTURE;
    }

    @Override
    public void render(SupplyCartEntity cart, float yaw, float g, PoseStack poseStack, MultiBufferSource multiBufferSource, int light) {
        super.render(cart, yaw, g, poseStack, multiBufferSource, light);
        poseStack.pushPose();

        poseStack.translate(0.0D, 1.4D, 0.0D);
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(yaw));

        this.model.setupAnim(cart, cart.tickCount + g, 0.0F, cart.tickCount + g, yaw, cart.getXRot());
        VertexConsumer vertexConsumer = multiBufferSource.getBuffer(this.model.renderType(CART_TEXTURE));
        this.model.renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        poseStack.popPose();
    }
}