package com.github.darkcwk.darkhud.listener;

import java.io.IOException;
import java.util.Map;

import com.github.darkcwk.darkhud.api.Data;
import com.github.darkcwk.darkhud.util.ConfigUtil;
import com.github.darkcwk.darkhud.util.Constant;
import com.github.darkcwk.darkhud.util.DataUtil;
import com.github.darkcwk.darkhud.util.ErrorUtil;
import com.github.darkcwk.darkhud.util.FreemarkerUtil;
import com.github.darkcwk.darkhud.util.HudRenderUtil;
import com.github.darkcwk.darkhud.util.HudRenderUtil.CalcPositionInfoFn;
import com.github.darkcwk.darkhud.util.HudRenderUtil.PositionInfo;

import freemarker.template.TemplateException;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public enum HudRenderListener implements HudRenderCallback {
    HUD_RENDER_LISTENER;

    private static final MinecraftClient client = MinecraftClient.getInstance();

    private long ltErrorTime = -1;
    private CalcPositionInfoFn ltFn = (_1, _2, w, h, i) -> new PositionInfo(0, h * i, w, h * (i + 1));

    private long rtErrorTime = -1;
    private CalcPositionInfoFn rtFn = (ww, _2, w, h, i) -> new PositionInfo(ww - w, h * i, ww, h * (i + 1));

    private long lbErrorTime = -1;
    private CalcPositionInfoFn lbFn = (_1, wh, w, h, i) -> new PositionInfo(0, wh - h * (i + 1), w, wh - h * i);

    private long rbErrorTime = -1;
    private CalcPositionInfoFn rbFn = (ww, wh, w, h, i) -> new PositionInfo(ww - w, wh - h * (i + 1), ww, wh - h * i);

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        if (client.options.debugEnabled) {
            return;
        }

        // 获取并更新数据
        Map<String, Data> data = DataUtil.getLatestData();

        // 渲染左上角
        if (ConfigUtil.getAsBoolean(Constant.LT_ENABLE_KEY)) {
            try {
                if (this.ltErrorTime == -1 || this.ltErrorTime < Constant.LT_FILE_PATH.toFile().lastModified()) {
                    HudRenderUtil.render(FreemarkerUtil.process(Constant.LT_FILE_NAME, data), drawContext, ltFn);

                    ltErrorTime = -1;
                }
            } catch (TemplateException | IOException e) {
                ErrorUtil.sendError("无法加载 lt.ftl!", e);
                this.ltErrorTime = System.currentTimeMillis();
            }
        }

        // 渲染右上角
        if (ConfigUtil.getAsBoolean(Constant.RT_ENABLE_KEY)) {
            try {
                if (this.rtErrorTime == -1 || this.rtErrorTime < Constant.RT_FILE_PATH.toFile().lastModified()) {
                    HudRenderUtil.render(FreemarkerUtil.process(Constant.RT_FILE_NAME, data), drawContext, rtFn);

                    rtErrorTime = -1;
                }
            } catch (TemplateException | IOException e) {
                ErrorUtil.sendError("无法加载 rt.ftl!", e);
                this.rtErrorTime = System.currentTimeMillis();
            }
        }

        // 渲染左下角
        if (ConfigUtil.getAsBoolean(Constant.LB_ENABLE_KEY)) {
            try {
                if (this.lbErrorTime == -1 || this.lbErrorTime < Constant.LB_FILE_PATH.toFile().lastModified()) {
                    HudRenderUtil.render(FreemarkerUtil.process(Constant.LB_FILE_NAME, data), drawContext, lbFn);

                    lbErrorTime = -1;
                }
            } catch (TemplateException | IOException e) {
                ErrorUtil.sendError("无法加载 lb.ftl!", e);
                this.lbErrorTime = System.currentTimeMillis();
            }
        }
        // 渲染右下角
        if (ConfigUtil.getAsBoolean(Constant.RB_ENABLE_KEY)) {
            try {
                if (this.rbErrorTime == -1 || this.rbErrorTime < Constant.RB_FILE_PATH.toFile().lastModified()) {
                    HudRenderUtil.render(FreemarkerUtil.process(Constant.RB_FILE_NAME, data), drawContext, rbFn);

                    rbErrorTime = -1;
                }
            } catch (TemplateException | IOException e) {
                ErrorUtil.sendError("无法加载 rb.ftl!", e);
                this.rbErrorTime = System.currentTimeMillis();
            }
        }
    }
}
