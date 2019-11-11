package myBean.music.impl;

import myBean.music.CompactDisc;
import org.springframework.stereotype.Component;

@Component
public class MayDay implements CompactDisc {

    @Override
    public void play() {
        System.out.println("播放五月天的音乐");
    }
}
