import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class ModelFile implements StatisticBusiness{

	@Override
	public ArrayList load() {
		ArrayList statList = new ArrayList();
		try
		{
			FileReader fr = new FileReader("statistics.dat");
			BufferedReader br = new BufferedReader(fr);
			
			String dt = br.readLine();
			int wBen, wCom, erg;
			LocalDateTime dateTime;
			while(dt!=null)
			{
				dateTime = LocalDateTime.parse(dt);
				wBen = Integer.valueOf(br.readLine());
				wCom = Integer.valueOf(br.readLine());
				erg = Integer.valueOf(br.readLine());
				Statistics stat = new Statistics(dateTime,wBen, wCom, erg);
				statList.add(stat);
				dt = br.readLine();
			}
		}
		catch(Exception e)
		{
			
		}
		return statList;
	}

	@Override
	public boolean save(ArrayList list) {
		try
		{
			FileWriter fw = new FileWriter("statistics.dat", false);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Iterator it = list.iterator();it.hasNext();)
			{
				Statistics stat = (Statistics)it.next();
				bw.append(stat.getDateTime().toString());
				bw.newLine();
				bw.append(String.valueOf(stat.getwBen()));
				bw.newLine();
				bw.append(String.valueOf(stat.getwCom()));
				bw.newLine();
				bw.append(String.valueOf(stat.getErg()));
				bw.newLine();
			}
			bw.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			return false;
		}
		
	}
}