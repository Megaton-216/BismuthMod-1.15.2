package com.github.BismuthMod.client.model;

import com.github.BismuthMod.entities.CapybaraEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CapybaraModel<T extends CapybaraEntity> extends EntityModel {

    private final ModelRenderer head;
    private final ModelRenderer neck;
    private final ModelRenderer body;
    private final ModelRenderer legfrontright;
    private final ModelRenderer bone3;
    private final ModelRenderer legfrontleft;
    private final ModelRenderer bone4;
    private final ModelRenderer legbackright;
    private final ModelRenderer bone;
    private final ModelRenderer legbackleft;
    private final ModelRenderer bone2;

    public CapybaraModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 15.34F, -2.48F);
        setRotationAngle(head, 0.0F, 0.0F, 0.0F);
        head.setTextureOffset(23, 31).addBox(-2.0F, -3.34F, -4.52F, 4.0F, 3.0F, 2.0F, 0.0F, false);
        head.setTextureOffset(0, 26).addBox(-1.5F, -3.34F, -7.52F, 3.0F, 3.0F, 3.0F, 0.0F, false);
        head.setTextureOffset(13, 0).addBox(1.4F, -3.74F, -3.22F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(0, 13).addBox(-2.4F, -3.74F, -3.22F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(23, 2).addBox(-1.5F, -0.84F, -7.02F, 3.0F, 1.0F, 5.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(-0.25F, -0.09F, -0.02F);
        head.addChild(neck);
        setRotationAngle(neck, -0.8727F, 0.0F, 0.0F);
        neck.setTextureOffset(26, 7).addBox(-1.95F, -0.1107F, -4.0516F, 2.0F, 2.0F, 4.0F, 0.0F, false);
        neck.setTextureOffset(13, 0).addBox(-0.55F, -0.1107F, -4.0516F, 3.0F, 2.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 18.1667F, 0.6667F);
        body.setTextureOffset(0, 13).addBox(-2.55F, -3.1667F, -5.6667F, 3.0F, 6.0F, 7.0F, 0.0F, false);
        body.setTextureOffset(0, 0).addBox(-0.45F, -3.1667F, -5.6667F, 3.0F, 6.0F, 7.0F, 0.0F, false);
        body.setTextureOffset(20, 20).addBox(-0.2F, -3.1667F, 1.3333F, 3.0F, 6.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(15, 8).addBox(-2.8F, -3.1667F, 1.3333F, 3.0F, 6.0F, 5.0F, 0.0F, false);
        body.setTextureOffset(11, 31).addBox(-2.5F, -2.1667F, 6.3333F, 5.0F, 5.0F, 1.0F, 0.0F, false);
        body.setTextureOffset(31, 13).addBox(-2.5F, -1.1667F, 7.3333F, 5.0F, 3.0F, 1.0F, 0.0F, false);

        legfrontright = new ModelRenderer(this);
        legfrontright.setRotationPoint(-2.0833F, 21.0F, -3.6667F);
        legfrontright.setTextureOffset(3, 3).addBox(-0.4167F, 0.0F, -0.3333F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legfrontright.setTextureOffset(4, 0).addBox(-0.4167F, 3.0F, -1.3333F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0833F, 3.0F, 0.6667F);
        legfrontright.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 1.5708F, 0.0F);
        bone3.setTextureOffset(0, 4).addBox(0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
        bone3.setTextureOffset(3, 2).addBox(0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        legfrontleft = new ModelRenderer(this);
        legfrontleft.setRotationPoint(2.0833F, 21.0F, -3.6667F);
        legfrontleft.setTextureOffset(0, 0).addBox(-0.5833F, 0.0F, -0.3333F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        legfrontleft.setTextureOffset(0, 5).addBox(-0.5833F, 3.0F, -1.3333F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(-0.0833F, 3.0F, 0.6667F);
        legfrontleft.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 1.5708F, 0.0F);
        bone4.setTextureOffset(3, 1).addBox(0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
        bone4.setTextureOffset(2, 0).addBox(0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        legbackright = new ModelRenderer(this);
        legbackright.setRotationPoint(-2.1875F, 20.375F, 4.875F);
        setRotationAngle(legbackright, 0.0F, 0.0F, 0.0F);
        legbackright.setTextureOffset(31, 17).addBox(-0.5625F, 0.625F, -1.875F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        legbackright.setTextureOffset(3, 14).addBox(-0.5625F, 2.625F, -0.375F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        legbackright.setTextureOffset(12, 14).addBox(-0.5625F, 3.625F, -1.375F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-0.0625F, 3.625F, 0.625F);
        legbackright.addChild(bone);
        setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
        bone.setTextureOffset(12, 13).addBox(0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
        bone.setTextureOffset(4, 13).addBox(0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        legbackleft = new ModelRenderer(this);
        legbackleft.setRotationPoint(2.1875F, 20.375F, 4.875F);
        setRotationAngle(legbackleft, 0.0F, 0.0F, 0.0F);
        legbackleft.setTextureOffset(12, 26).addBox(-0.4375F, 0.625F, -1.875F, 1.0F, 2.0F, 3.0F, 0.0F, false);
        legbackleft.setTextureOffset(13, 2).addBox(-0.4375F, 2.625F, -0.375F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        legbackleft.setTextureOffset(0, 6).addBox(-0.4375F, 3.625F, -1.375F, 1.0F, 0.0F, 1.0F, 0.0F, false);

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0625F, 3.625F, 0.625F);
        legbackleft.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 1.5708F, 0.0F);
        bone2.setTextureOffset(2, 13).addBox(0.5F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
        bone2.setTextureOffset(12, 6).addBox(0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 180F);
        this.legbackright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legbackleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legfrontright.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legfrontleft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legfrontright.render(matrixStack, buffer, packedLight, packedOverlay);
        legfrontleft.render(matrixStack, buffer, packedLight, packedOverlay);
        legbackright.render(matrixStack, buffer, packedLight, packedOverlay);
        legbackleft.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
