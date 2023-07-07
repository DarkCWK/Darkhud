package com.github.darkcwk.darkhud.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.Window;

public class HudRenderUtil {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void render(String text, DrawContext drawContext, CalcPositionInfoFn fn) {
        String[] lines = text.lines().toArray(String[]::new);
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            Window window = client.getWindow();
            int ww = window.getScaledWidth();
            int wh = window.getScaledHeight();

            TextRenderer renderer = client.textRenderer;
            int h = renderer.fontHeight;
            int w = renderer.getWidth(line);

            PositionInfo info = fn.fn(ww, wh, w, h, i);

            drawContext.fill(info.x1, info.y1, info.x2, info.y2, -1873784752);
            drawContext.drawText(renderer, line, info.x1, info.y1, 14737632, false);
        }
    }

    public static class PositionInfo {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public PositionInfo(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    @FunctionalInterface
    public static interface CalcPositionInfoFn {
        PositionInfo fn(int ww, int wh, int w, int h, int i);
    }
}
