package org.example;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("MTAxMzcyNjU4MjA3NjA4ODMzMA.Gywcl6.dIUlOZgHhgLZldSCXnJ-yEEoSYCyz3tO98VkTY", GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setActivity(Activity.listening("to you mom"))
                .addEventListeners(new Main())
                .build();
    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();


        if (content.equals("ahoj")){
            MessageChannel messageChannel = event.getChannel();
            messageChannel.sendMessage("čo chceš").queue();
        }
    }
}