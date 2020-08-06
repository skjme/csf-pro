package cn.chaseshu.shardingsphere.test.core.api.service;

import java.sql.SQLException;

public interface ExampleService {
    
    /**
     * Initialize environment.
     * 
     * @throws SQLException SQL exception
     */
    void initEnvironment() throws SQLException;
    
    /**
     * Clean environment.
     * 
     * @throws SQLException SQL exception
     */
    void cleanEnvironment() throws SQLException;
    
    /**
     * Process success.
     * 
     * @throws SQLException SQL exception
     */
    void processSuccess() throws SQLException;
    
    /**
     * Process failure.
     * 
     * @throws SQLException SQL exception
     */
    void processFailure() throws SQLException;
    
    /**
     * Print data.
     * 
     * @throws SQLException SQL exception
     */
    void printData() throws SQLException;
}
