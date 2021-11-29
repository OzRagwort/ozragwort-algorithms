package com.ozragwort.code.baekjoon;

import java.io.*;
import java.util.*;

public class q16434 {

	static class LifeObject {
		long maxHp;
		long hp;
		long attack;

		public LifeObject(long maxHp, long attack) {
			this.maxHp = maxHp;
			this.hp = maxHp;
			this.attack = attack;
		}

		public long getHp() {
			return hp;
		}

		public long getAttack() {
			return attack;
		}

		public void improveAttack(long attack) {
			this.attack += attack;
		}

		public void healHp(long hp) {
			this.hp = Math.min(this.maxHp, this.hp + hp);
		}

		public void attacked(long attack) {
			this.hp -= attack;
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		long userAttack = Long.parseLong(stk.nextToken());
		long userMaxHp = 0;
		LifeObject user = new LifeObject(userMaxHp, userAttack);
		long maxAttackedPoint = 0;

		for (int n = 0; n < N; n++) {
			stk = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(stk.nextToken());
			if (t == 1) {
				int monsterAttack = Integer.parseInt(stk.nextToken());
				int monsterMapHp = Integer.parseInt(stk.nextToken());
				LifeObject monster = new LifeObject(monsterMapHp, monsterAttack);
				fightMonster(user, monster);
			} else {
				int improveAttackPoint = Integer.parseInt(stk.nextToken());
				int healHpPoint = Integer.parseInt(stk.nextToken());
				maxAttackedPoint = Math.max(maxAttackedPoint, user.getHp() * -1);
				user.improveAttack(improveAttackPoint);
				user.healHp(healHpPoint);
			}
		}

		long needMinHp = Math.max(maxAttackedPoint + 1, 1 - user.getHp());
		System.out.println(needMinHp);

		bw.flush();
		bw.close();
		br.close();
	}

	private LifeObject fightMonster(LifeObject user, LifeObject monster) {
		long monsterHp = monster.getHp();
		long userAttack = user.getAttack();
		long monsterAttackCount = (monsterHp - 1) / userAttack;
		user.attacked(monster.getAttack() * monsterAttackCount);
		return user;
	}
}
