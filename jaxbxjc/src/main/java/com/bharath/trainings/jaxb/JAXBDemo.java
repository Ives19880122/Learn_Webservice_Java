package com.bharath.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

public class JAXBDemo {
	public static void main(String[] args){
		try {
			// 1.序列化為XML (marshaller)
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
			
			// 2.建立病患物件
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Bharath");
			
			// 3.marshaller轉化XML物件
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			
			// 4.印出writer結果
			System.out.println(writer.toString());
			
			// 5.反序列化回病患物件(unmarshaller)
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println(patientResult.getName());
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
