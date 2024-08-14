package com.mytube;

public class EmailService implements Notifyable{
    @Override
    public Boolean sendNotification(String detail) {
        System.out.println("Notifying " + detail + "...");
        System.out.println("Done!\n");
        return true;
    }
}
