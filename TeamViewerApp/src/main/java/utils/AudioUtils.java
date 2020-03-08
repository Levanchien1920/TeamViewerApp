/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.sound.sampled.AudioFormat;

/**
 *
 * @author phanv
 */
public class AudioUtils {

    private AudioUtils() {
    }

    public static AudioFormat getAudioFormat() {
        float sampleRate = 8000.0f;
        int sampleSizeInBits = 8;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        return audioFormat;
    }
}
