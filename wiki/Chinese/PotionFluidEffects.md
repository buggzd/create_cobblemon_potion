### **宝可梦动力模组特性 Wiki**

#### **药水流体效果**

当玩家或其他生物实体接触到由本模组添加的宝可梦药水流体方块（包括源方块和流动方块）时，会根据药水的种类获得相应的状态效果 (Buff)。药水的等级越高，提供的效果通常也越强力。

**治疗类药水效果:**

*   **药酿 (Medicinal Brew):** 无接触效果。
*   **伤药 (Potion):** 接触时获得 **再生 I** (Regeneration I) 效果。
*   **好伤药 (Super Potion):** 接触时获得 **再生 II** (Regeneration II) 效果。
*   **厉害伤药 (Hyper Potion):** 接触时获得 **再生 III** (Regeneration III) 效果。
*   **全满药 (Max Potion):** 接触时获得 **再生 IV** (Regeneration IV) 效果。

*(未来可能会添加更多类型的药水效果，如状态治疗、PP回复等)*

---

#### **药水流体变质 (药效挥发)**

直接放置在世界中、没有使用容器（如桶或储罐）盛装的宝可梦药水流体，会因暴露在环境中而逐渐失去效力。

**机制:**

*   药水方块会响应 Minecraft 的**随机刻 (Random Tick)** 系统。
*   每次接收到随机刻时，药水方块有一定几率**降级**。
*   降级意味着它会转变为低一级的药水方块。例如，**全满药 (Max Potion)** 流体方块在一段时间后会降级为 **厉害伤药 (Hyper Potion)** 流体方块，厉害伤药会降级为好伤药，以此类推。
*   药水等级越高，其降级的**频率越快**（即需要更少的平均随机刻数来触发降级）。

**(效果演示)**
![药水挥发/降级过程](../Pictures/potionVolatilization.gif)

**各类药水平均挥发/降级时间:**

以下时间基于方块接收到的平均随机刻次数。一次随机刻大约平均发生在每个方块上每 **68.27 秒**。请注意这是平均值，实际降级时间会有随机波动。

*   **药酿 (Medicinal Brew):** 平均约 **240 次**随机刻后降级 (约 **4.5 小时**)。*(最终可能降级为水方块或其他基础流体)*
*   **伤药 (Potion):** 平均约 **120 次**随机刻后降级为 **药酿 (Medicinal Brew)** (约 **2.25 小时**)。
*   **好伤药 (Super Potion):** 平均约 **60 次**随机刻后降级为 **伤药 (Potion)** (约 **1.1 小时**)。
*   **厉害伤药 (Hyper Potion):** 平均约 **30 次**随机刻后降级为 **好伤药 (Super Potion)** (约 **34 分钟**)。
*   **全满药 (Max Potion):** 平均约 **15 次**随机刻后降级为 **厉害伤药 (Hyper Potion)** (约 **17 分钟**)。


### **Create Cobblemon Potions Mod Features Wiki**

#### **Potion Fluid Effects**

When a player or other living entity comes into contact with Pokémon potion fluid blocks added by this mod (including both source blocks and flowing blocks), they will receive corresponding status effects (Buffs) based on the type of potion. Higher-tier potions generally provide stronger effects.

**Healing-Type Potion Effects:**

*   **Medicinal Brew:** No contact effect.
*   **Potion:** Grants **Regeneration I** upon contact.
*   **Super Potion:** Grants **Regeneration II** upon contact.
*   **Hyper Potion:** Grants **Regeneration III** upon contact.
*   **Max Potion:** Grants **Regeneration IV** upon contact.

*(More types of potion effects, such as status healing or PP restoration, may be added in the future)*

---

#### **Potion Fluid Degradation (Volatilization)**

Pokémon potion fluids placed directly into the world without being contained (e.g., in buckets or tanks) will gradually lose their potency due to environmental exposure.

**Mechanism:**

*   Potion fluid blocks respond to Minecraft's **Random Tick** system.
*   Each time a block receives a random tick, there is a chance it will **degrade**.
*   Degradation means the block transforms into the next lower tier of potion fluid block. For example, a **Max Potion** fluid block will eventually degrade into a **Hyper Potion** fluid block, which will then degrade into a Super Potion block, and so on.
*   Higher-tier potions degrade **more quickly** (i.e., they require fewer average random ticks to trigger degradation).

**(Visual Demonstration)**
![Potion Volatilization/Degradation Process](../Pictures/potionVolatilization.gif)
*(Ensure the GIF file path is correct or replace it with an actual image/video link)*

**Average Degradation Time per Potion Type:**

The times below are based on the average number of random ticks received by the block. On average, a random tick occurs for a specific block approximately every **68.27 seconds**. Note that this is an average, and actual degradation times will vary randomly.

*   **Medicinal Brew:** Degrades after an average of approx. **240** random ticks (approx. **4.5 hours**). *(Likely degrades into Water or another base fluid)*
*   **Potion:** Degrades into **Medicinal Brew** after an average of approx. **120** random ticks (approx. **2.25 hours**).
*   **Super Potion:** Degrades into **Potion** after an average of approx. **60** random ticks (approx. **1.1 hours**).
*   **Hyper Potion:** Degrades into **Super Potion** after an average of approx. **30** random ticks (approx. **34 minutes**).
*   **Max Potion:** Degrades into **Hyper Potion** after an average of approx. **15** random ticks (approx. **17 minutes**).

---
