package ubiquitaku;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    private JDA jda = null;
    private String token = "c822e98781736117227427e0903fd22a5a3b5a78560d5bf6f7be110aae964a9e";

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        try {
            jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES)
                    .setRawEventsEnabled(true)
                    .setActivity(Activity.playing("悲しい人生"))
                    .build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if (e.getAuthor().isBot()) {
            return;
        }
        String msg = e.getMessage().getContentRaw();
        e.getTextChannel().sendMessage("てすと").queue();
    }
}
