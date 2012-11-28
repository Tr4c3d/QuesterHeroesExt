package net.citizensnpcs.questers.rewards;

import net.citizensnpcs.questers.data.ReadOnlyStorage;
import net.citizensnpcs.utils.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class HealthReward implements Requirement, Reward {
	private final int reward;
	private final boolean take;

	HealthReward(int reward, boolean take) {
		this.reward = reward;
		this.take = take;
	}

	@Override
	public boolean fulfilsRequirement(Player player) {
		return player.getHealth() - reward > 0;
	}

	@Override
	public String getRequiredText(Player player) {
		return ChatColor.GRAY + "You need "
				+ StringUtils.wrap(player.getHealth() - reward, ChatColor.GRAY)
				+ " more health.";
	}

	@Override
	public void grant(Player player, int UID) {
		player.setHealth(Math.min(player.getMaxHealth(),
				take ? player.getHealth() - reward : player.getHealth()
						+ reward));
	}

	@Override
	public boolean isTake() {
		return take;
	}

    public static class HealthRewardBuilder implements RewardBuilder {
		@Override
		public Reward build(ReadOnlyStorage storage, String root, boolean take) {
			return new HealthReward(storage.getInt(root + ".amount"), take);
		}
	}
}