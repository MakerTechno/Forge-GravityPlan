package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.registry.ItemRegistration;

public class ModChineseLanguageProvider extends LanguageProvider {
    public ModChineseLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, GravityPlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.furniture", "重力计划");
        add(ItemRegistration.ICON.get(), "这只是个作为创造模式物品栏图标的物品，没什么用，你拿它干嘛？");
        add("msg.gravityplan.introduce", "这是Maker使用IntelliJ idea编写的一个简单模组。\n" +
                "现在，你TM还要啥?我TM都说了，这只是个用作图标的物品!啥用也没有!!!");

        add("description.gravityplan.first", "该力将你推向：");
        add("description.gravityplan.up", "上");
        add("description.gravityplan.down", "下");
        add("description.gravityplan.left", "左");
        add("description.gravityplan.right", "右");
        add("description.gravityplan.forward", "前");
        add("description.gravityplan.back", "后");
        add("description.gravityplan.force", "力量大小");
    }

}
