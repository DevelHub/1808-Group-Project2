package com.revature.controllers;

import java.io.*;
import java.net.*;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.CompanyReviews;
import com.revature.services.CompanyReviewsService;

@CrossOrigin
@RestController
@RequestMapping("company")
public class CompanyReviewsController {

	@Autowired
	private CompanyReviewsService crs;
	
	private static InetAddress host;
	private final int OUTPORT = 1241;
	private final int INPORT = 1242;
	
	@GetMapping("sendpacket")
	private void sender() {
		try {
			host = InetAddress.getLocalHost();
		} catch(UnknownHostException ex) {
			System.out.println("Host ID not found!");
			System.exit(1);
		}
		accessServer();
	}
	
	private void accessServer() {
		Socket link = null;
		try {
			link = new Socket(host, OUTPORT);
			int count = 0;
			String data, sentence;
			DatagramSocket client = new DatagramSocket();
			DatagramSocket receiver = new DatagramSocket(INPORT);
			DatagramPacket sendPacket;
			DatagramPacket receivePacket;
			byte[] sendData = new byte[3];
			byte[] receiveData = new byte[5];
			System.out.println(10 + "Packets are sent to Reciever.");
			for (int i = 0; i < 10; i++) {
				data = i + "";
				sendData = data.getBytes();
				sendPacket = new DatagramPacket(sendData, sendData.length, host, OUTPORT);
				client.send(sendPacket);
				System.out.print("| " + i + " ");
				delay();
			}
			System.out.println("\n");
			client.close();
			while(true) {
				receivePacket = new DatagramPacket(receiveData, receiveData.length);
				receiver.receive(receivePacket);
				sentence = new String( receivePacket.getData() );
				if(sentence.startsWith("A"))
					System.out.println("RECEIVED: " + sentence + " " + Arrays.toString(receivePacket.getData()));
				count++;
				if(count == 10)
					break;
			}
			receiver.close();
		} catch(IOException io) {
			io.printStackTrace();
		}
		finally {
			try {
				System.out.println("\n* Closing connection*");
				link.close();
			} catch (IOException io) {
				System.exit(1);
			}
		}
	}
	
	private void delay() {
		try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException ie) {
			System.out.println("Delay failure");
		}
	}
	
	@PostMapping("review")
	public int save(@RequestBody CompanyReviews cr) {
		System.out.println("Adding Company Review");
		return crs.save(cr);
	}
	
	@GetMapping
	public List<CompanyReviews> findAll() {
		return crs.findAll();
	}
	
//	@GetMapping("{companyId}")
//	public List<CompanyReviews> findByCompanyId(@PathVariable int companyId) {
//		return crs.findByCompanyId(companyId);
//	}
//	
//	@PatchMapping("review-update")
//	public ResponseEntity<CompanyReviews> update(@RequestBody CompanyReviews cr) {
//		CompanyReviews ctr = crs.findByCompanyId(cr.getCompanyId()).get(0);
//		ctr.setReview(cr.getReview());
//		crs.update(ctr);
//		ResponseEntity<CompanyReviews> re = new ResponseEntity<CompanyReviews>(ctr, HttpStatus.CREATED);
//		return re;
//	}
	
}
