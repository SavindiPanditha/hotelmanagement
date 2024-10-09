package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.bean.SearchBean;
import com.mvc.util.DBConnection;

public class SearchDao {

	
	public String searchHotel(SearchBean searchBean) {
        // Get individual fields from the SearchBean
        String location = searchBean.getLocation();
        String date = searchBean.getDate();
        
        //INNER JOIN booking on hotel.hotel_id = hotel.organi_id WHERE booking.event_date <> :date or event_type <> :type
	        // SQL query to search for records based on location and date
	        String query = "SELECT * FROM hotels";
	        String resultMessage = "No events found for the given location and date.";

	        try (Connection con = DBConnection.createConnection()) {
	            // Test the database connection
	            if (con == null) {
	                System.out.println("Connection to the database failed.");
	                return "Database connection failed!";
	            } else {
	                System.out.println("Database connection successful.");
	            }

	            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
	                // Set the parameters for the query
	              //  preparedStatement.setString(1,location);
	                //preparedStatement.setString(2, date);

	                // Execute the query
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {

	                    if (resultSet.next()) {
	                        resultMessage = "Events found for the given location and date:";
	                        // Process resultSet to retrieve event details if needed
	                        
	                        
	                        
	                       // Allocates memory for 5 integers

	                        
	                        do {
	                        	
	                        	 System.out.println("SQL Error: " );
	                            // Example: Retrieve event details and append to resultMessage
	                            //String eventName = resultSet.getString("eventName");
	                            //String eventDescription = resultSet.getString("eventDescription");
	                           // resultMessage += "\nEvent: " + eventName + ", Description: " + eventDescription;
	                        } while (resultSet.next());
	                    } else {
	                        resultMessage = "No events found for the given location and date.";
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("SQL Error: " + e.getMessage());  // Print SQL error message for debugging
	            e.printStackTrace();  // Log the stack trace for further investigation
	        }

	        return resultMessage;  // Return the result of the search process
	    }
	}
