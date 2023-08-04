package nowebsite.maker.gravityplan.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import nowebsite.maker.gravityplan.GravityPlan;
import nowebsite.maker.gravityplan.registry.ItemRegistration;

public class ModEnglishLanguageProvider extends LanguageProvider {
    public ModEnglishLanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, GravityPlan.MOD_ID, locale);
    }

    protected void addTranslations() {
        add("itemGroup.gravityplan", "Gravity Plan");
        add(ItemRegistration.ICON.get(),"This is just an useless item for creative mod tab as an icon, why take it out?");
        add("msg.gravityplan.introduce", "This mod is a simple mod written by Maker, using IntelliJ idea.\n" +
                " Now, WHAT DO YOU WANT? I SAID, IT'S JUST AN ICON!!!");

        add("description.gravityplan.first", "An Force that takes you ");
        add("description.gravityplan.up", "up");
        add("description.gravityplan.down", "down");
        add("description.gravityplan.left", "left");
        add("description.gravityplan.right", "right");
        add("description.gravityplan.forward", "forward");
        add("description.gravityplan.back", "back");
        add("description.gravityplan.force", "Force size");
    }
}
