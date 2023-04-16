package io.github.miniplaceholders.connect;

public enum InternalPlatform {

    PAPER, VELOCITY, KRYPTON, FABRIC;

    private static InternalPlatform actualPlatform;

    public static void platform(final InternalPlatform platform){
        InternalPlatform.actualPlatform = platform;
    }

    public static InternalPlatform platform(){
        return InternalPlatform.actualPlatform;
    }
}
