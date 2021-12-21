package com.brqdford.staffhelp;

import com.google.inject.Inject;
import com.velocitypowered.api.command.Command;
import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.slf4j.Logger;

@Plugin(id = "staffhelp", name = "StaffHelp", version = "1.0", description = "staffhelp", authors = {"Brqdford"})
public class staffhelp {
    private final ProxyServer server;

    @Inject
    public staffhelp(ProxyServer server, Logger logger) { this.server = server; }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.server.getCommandManager().register("staffhelp", (Command)new SimpleCommand() {
            public void execute(Invocation invocation) {
                if (invocation.source().hasPermission("staffhelp.use")){
                    invocation.source().sendMessage(Component.text("        ---------- (Staff Help) ----------").color((TextColor)NamedTextColor.AQUA));
                    invocation.source().sendMessage(Component.text("1. Helper Commands").color((TextColor)NamedTextColor.GREEN).clickEvent(ClickEvent.runCommand("/staffhelp1")));
                    invocation.source().sendMessage(Component.text("2. Moderator Commands").color((TextColor)NamedTextColor.DARK_AQUA).clickEvent(ClickEvent.runCommand("/staffhelp2")));
                    invocation.source().sendMessage(Component.text("3. Admin Commands").color((TextColor)NamedTextColor.RED).clickEvent(ClickEvent.runCommand("/staffhelp3")));
                }
                return;
            }
        }, new String[] { "sh" });
        this.server.getCommandManager().register("staffhelp1", (Command)new SimpleCommand() {
            public void execute(Invocation invocation) {
                if (invocation.source().hasPermission("staffhelp1.use")){
                    invocation.source().sendMessage(Component.text("        ---------- (Helper Commands) ----------").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/invsee (Look into players inventories, cannot modify.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/alts (See if a player has any alternative accounts.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/socialspy (Spy on private messages.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/vsocialspy (Spy on network-wide private messages.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/ban (Max duration of 1d.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/kick (Kicks a player from the network.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/mute (Mutes a player on the network.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/warn (Give a player a warning.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/breport reports (Lists current reports.)").color((TextColor)NamedTextColor.GREEN));
                    invocation.source().sendMessage(Component.text("/breport remove <player> (Removes report from a player.)").color((TextColor)NamedTextColor.GREEN));
                }
                return;
            }
        }, new String[] { "sh1" });
        this.server.getCommandManager().register("staffhelp2", (Command)new SimpleCommand() {
            public void execute(Invocation invocation) {
                if (invocation.source().hasPermission("staffhelp2.use")){
                    invocation.source().sendMessage(Component.text("        ---------- (Moderator Commands) ----------").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/invsee (Look and modify players inventories.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/tp or /teleport (Teleports to a player.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/tptoggle (Disables people being able to tpa to you.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/ban (Max duration of 14d.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/vanish (Goes in vanish mode, so players cant see you.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/send (Send a player to a server.)").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/enick(1.7.10) /nnick(1.12.2) (Changes nickname of a player.(On 1.12.2 please do not perform nick name changes in game, for now contact an admin to put through console.))").color((TextColor)NamedTextColor.DARK_AQUA));
                    invocation.source().sendMessage(Component.text("/staffhide (Hides yourself from /staff.)").color((TextColor)NamedTextColor.DARK_AQUA));
                }
                return;
            }
        }, new String[] { "sh2" });
        this.server.getCommandManager().register("staffhelp3", (Command)new SimpleCommand() {
            public void execute(Invocation invocation) {
                if (invocation.source().hasPermission("staffhelp3.use")){
                    invocation.source().sendMessage(Component.text("        ---------- (Admin Commands) ----------").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/antivpn (See if a player has a vpn/proxy.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/maintenance (Turns maintenance on/off on a certain or all servers.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/timings on or /sponge timings (Turns on a timings profiler to check for lag.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/timings paste or /sponge timings paste (Pastes a link to the profiler.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/profile e 60 (Profiles entities for 60 seconds (1.7.10))").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/ob_inventory restore (username) (.datfile) (Restores Inventory for a player from save.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/co inspect (Turns on inspector mode for 1.7.10 modpacks.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/pr inspect (Turns on inspector mode for 1.12.2 modpacks.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/lagg check (Check entities, tps, loaded chunks.(1.7.10))").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/lp user <username> <permission:parent> <set:add> <permission:group> (Give ranks to players or add permissions to player.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/alert (Sends an alert message to all players.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/find <player> (Find out what server a player is on.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("/serverinfo <server> (Find out how many players are on a server.)").color((TextColor)NamedTextColor.RED));
                    invocation.source().sendMessage(Component.text("(Download laggoggles and tickcentral for block lag checking on some 1.12.2 modpacks.)").color((TextColor)NamedTextColor.RED));
                }
                return;
            }
        }, new String[] { "sh3" });
    }

}
