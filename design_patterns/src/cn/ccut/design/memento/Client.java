package cn.ccut.design.memento;

public class Client {
    public static void main(String[] args) {
        // 大战boss前
        // 初始化游戏角色初始状态，三项指标都为100
        GameRole gameRole = new GameRole();
        gameRole.initialState();
        gameRole.displayState();

        // 保存进度信息
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setMemento(gameRole.saveState());

        // 大战boss，损耗严重
        gameRole.fight();
        gameRole.displayState();

        // 回复到之前状态
        gameRole.recoveryState(caretaker.getMemento());
        gameRole.displayState();
    }
}
