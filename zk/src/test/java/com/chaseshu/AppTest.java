package com.chaseshu;

import static org.junit.Assert.assertTrue;

import com.chaseshu.lock.ZookeeperImproveLock;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private ZookeeperImproveLock zookeeperImproveLock;

    @Before
    public void init(){
        this.zookeeperImproveLock = new ZookeeperImproveLock();
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void testLock()
    {
        zookeeperImproveLock.lock();
    }
}
