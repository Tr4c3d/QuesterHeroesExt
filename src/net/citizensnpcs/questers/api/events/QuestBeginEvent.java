package net.citizensnpcs.questers.api.events;

import net.citizensnpcs.questers.quests.Quest;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class QuestBeginEvent extends QuestEvent implements Cancellable {
    private boolean cancelled = false;

    public QuestBeginEvent(Quest quest, Player player) {
        super(quest, player);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
