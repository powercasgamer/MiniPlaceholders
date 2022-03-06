package me.dreamerzero.miniplaceholders.velocity;

import java.util.function.BiFunction;
import java.util.function.Function;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

/**
 * Expansion that contains placeholders
 */
public interface Expansion {
    /**
     * Get the expansion name
     * @return the expansion name
     */
    String name();

    /**
     * Get the {@link TagResolver} of the desired {@link Audience}
     * @param audience
     * @since 1.0.0
     * @return
     */
    TagResolver audiencePlaceholders(Audience audience);

    /**
     * Get the relational placeholders based on two audiences
     * @param audience
     * @param otherAudience
     * @since 1.0.0
     * @return
     */
    TagResolver relationalPlaceholders(Audience audience, Audience otherAudience);

    /**
     * Get global placeholders
     * @since 1.0.0
     * @return the global placeholders
     */
    TagResolver globalPlaceholders();

    /**
     * Register this expansion
     * @since 1.0.0
     */
    void register();

    /**
     * Creates a new Expansion Builder
     * @param name the expansion name
     * @return a new expansion builder
     */
    public static Expansion.Builder builder(String name){
        return new ExpansionImpl.Builder(name);
    }

    /**
     * Expansion Builder
     */
    public static interface Builder {
        /**
         * Adds an audience placeholder
         *
         * Example use:
         * <pre>
         *  Expansion.Builder builder = Expansion.builder("player");
         *  builder.audiencePlaceholder("name", audience -> {
         *      if(audience instanceof Player){
         *          return Component.text(((Player)audience).getUsername());
         *      } else {
         *          return Component.empty();
         *      }
         *  });
         *  Expansion expansion = builder.build();
         * </pre>
         *
         * then use it:
         *
         * <pre>
         *  Player player = event.getPlayer();
         *  TagResolver resolver = expansion.audiencePlaceholder(player);
         *  Component messageReplaced = MiniMessage.deserialize({@link String}, resolver);
         * </pre>
         * @param name the placeholder name
         * @param placeholder the placeholder
         * @since 1.0.0
         * @return the {@link Builder} itself
         */
        Builder audiencePlaceholder(String name, Function<Audience, Component> placeholder);

        /**
         * Adds an Relational Placeholder based on two audiences
         *
         * This type of placeholder allows you to create
         * components based on a 2-audiences relationship,
         * one is the one on which the placeholder
         * is based and the other is the one on which
         * the placeholder is displayed.
         * 
         * 
         * @param name
         * @param placeholder
         * @since 1.0.0
         * @return
         */
        Builder relationalPlaceholder(String name, BiFunction<Audience, Audience, Component> placeholder);

        /**
         * Adds a global placeholder
         * @param name
         * @param placeholder
         * @since 1.0.0
         * @return
         */
        Builder globalPlaceholder(String name, Tag placeholder);

        /**
         * Adds a global tagresolver placeholder
         * @param name
         * @param resolver
         * @return
         */
        Builder globalPlaceholder(String name, TagResolver resolver);

        /**
         * Adds a global component placeholder
         * @param name
         * @param component
         * @return
         */
        default Builder globalPlaceholder(String name, ComponentLike component) {
            return this.globalPlaceholder(name, Tag.selfClosingInserting(component));
        }

        /**
         * Build the Expansion
         * @return the new expansion
         */
        Expansion build();
    }
}