package ch03.wait_notify_insert_test;

public class Run {


    // 等待wait 通知notify 交替（交叉）备份
    public static void main(String[] args) {

        DBTools dbTools = new DBTools();

        for(int i = 0;i < 20; i++){
            BackupA backupA = new BackupA(dbTools);
            backupA.start();

            BackupB backupB = new BackupB(dbTools);
            backupB.start();
        }
    }
}
