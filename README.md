# Darkhud
A Minecraft custom hud, using [Freemarker template engine](https://freemarker.apache.org/)...

My code is terrible, I apologize... English also.

There are four positions that can be edited

`path-to-version folder/config/darkhud/template/lt.ftl` => top left corner

`path-to-version folder/config/darkhud/template/rt.ftl` => upper right corner

`path-to-version folder/config/darkhud/template/lb.ftl` => left lower corner

`path-to-version folder/config/darkhud/template/rb.ftl` => lower right corner

Command:

`/darkhud query <lt|rt|lb|rb>`: Query display status

`/darkhud toggle <lt|rt|lb|rb>`: Switch display

`/darkhud edit <lt|rt|lb|rb>`: Edit template file

Inject the following data into the template during use

```java
class DarkhudData {
    // style
    StyleData style;

    // frame rate
    int fps;

    // millisecond per tick
    float mspt;

    // ticks Per Second
    int tps;

    // latency
    int latency;

    // biome id
    String biomeId;

    // dimension id
    String dimensionId;

    // is raining?
    boolean raining;

    // is thundering?
    boolean thundering;

    // is singleplayer?
    boolean singleplayer;

    // time of day
    int time;

    // light related
    LightData light;

    // player related
    PlayerData player;
}
```

```java
class StyleData {
    String black = "§0";
    String darkBlue = "§1";
    String darkGreen = "§2";
    String darkAqua = "§3";
    String darkRed = "§4";
    String darkPurple = "§5";
    String gold = "§6";
    String gray = "§7";
    String darkGray = "§8";
    String blue = "§9";
    String green = "§a";
    String aqua = "§b";
    String red = "§c";
    String lightPurple = "§d";
    String yellow = "§e";
    String white = "§f";

    String obfuscated = "§k";
    String bold = "§l";
    String strikethrough = "§m";
    String underline = "§n";
    String italic = "§o";

    String reset = "§r";
}
```

```java
class LightData {
    // block light
    int block;

    // sky light
    int sky;

    // calculated total light
    int total;
}
```

```java
class PlayerData {
    // targeted block related
    BlockData targetedBlock;

    // targeted entity related
    EntityData targetedEntity;

    // items in hand related
    HandData hand;

    // armor related
    ArmorData armor;
}
```

```java
class BlockData {
    // is has blockstate?
    boolean has;

    // block name
    String name;

    // block property, key is the property name
    Map<String, PropertyData> properties;
}
```

```java
class PropertyData {
    // property value
    Object value;

    // possible values of property
    Collection<?> values;
}
```

```java
class EntityData {
    // is has entity?
    boolean has;

    // entity name
    String name;

    // entity NBT data, https://minecraft.fandom.com/wiki/Entity_format
    // This is a hash value, https://freemarker.apache.org/docs/pgui_datamodel_parent.html
    // Additional data: nbt.has => Is there any data
    NbtData nbt;

    // default attribute value..., they are not in the NBT data
    // This is a hash value, https://freemarker.apache.org/docs/pgui_datamodel_parent.html
    // e.g. Max Health: darkhud.player.targetedEntity.baseAttribute["generic.max_health"]
    //   => Max Health: 20.0
    BaseAttributeData baseAttribute;
}
```

```java
class HandData {
    // main hand item
    ItemData main;

    // off hand item
    ItemData off;
}
```

```java
class ItemData {
    // is has item?
    boolean has;

    // item name
    String name;

    // item nbt data, https://minecraft.fandom.com/wiki/Player.dat_format#Item_structure
    // This is a hash value, https://freemarker.apache.org/docs/pgui_datamodel_parent.html
    // Additional data: nbt.has => Is there any data
    NbtData nbt;

    // item durable
    // if not, then it's 0
    int maxDamage;
}
```

```java
class ArmorData {
    // helmet
    ItemData helmet;

    // chestplate
    ItemData chestplate;

    // leggings
    ItemData leggings;

    // boots
    ItemData boots;
}
```
