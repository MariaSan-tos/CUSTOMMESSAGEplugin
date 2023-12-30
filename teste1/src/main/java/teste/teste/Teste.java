package teste.teste;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Teste extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this,this);

        System.out.println("PLUGIN ATIVADO");

        ItemStack Cabeca = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta CabecaMeta = Cabeca.getItemMeta();
        assert CabecaMeta != null;
        CabecaMeta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Ferro Podereso");
        CabecaMeta.setLore(List.of("Ele te dá o Poder","de enxergar ferros...."));
        Cabeca.setItemMeta(CabecaMeta);

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "teste"), Cabeca);
        recipe.shape("XXX","XCX","XXX");
        recipe.setIngredient('X', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.ENCHANTED_GOLDEN_APPLE);

        Bukkit.addRecipe(recipe);
        System.out.println("Receita adicionada com sucesso!");
    }

    @EventHandler
    public void PlayerMessage(PlayerJoinEvent event){
        String player = event.getPlayer().getName();
        String message = ChatColor.YELLOW + " " +ChatColor.BOLD + "Bem vindo " + ChatColor.AQUA + " " + ChatColor.BOLD + player + ChatColor.YELLOW + " " + ChatColor.BOLD + "! :3 " ;

        event.setJoinMessage(message);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
