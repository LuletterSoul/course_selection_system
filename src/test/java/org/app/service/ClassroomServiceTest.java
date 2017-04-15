package org.app.service;


import org.app.entity.Classroom;
import org.app.entity.TeachingBuilding;
import org.junit.Test;
import org.junit.Before;


/**
 * ClassroomService Tester.
 * 
 * @author <Authors name>
 * @since
 * 
 *        <pre>
 * 四月 13, 2017
 *        </pre>
 * 
 * @version 1.0
 */
public class ClassroomServiceTest extends BaseServiceTest<Classroom,Integer>
{
    private ClassroomService classroomService;

    @Before
    public void buildClassroomService()
        throws Exception
    {
        classroomService = (ClassroomService)getContext().getBean("classroomService");
    }

    /**
     * Method: setClassroomRepository(ClassroomRepository classroomRepository)
     */
    @Test
    public void testBatchSaveClassrooms()
        throws Exception
    {
        String classDoorName, buildingName="第二教学楼";
        String location="";
        int capicity=60;
        TeachingBuilding building = new TeachingBuilding();
        building.setBuildingName(buildingName);
        for (int i =1;i<=5;i++)
        {
            for(int k=1;k<=3;++k)
            {
                switch (k)
                {
                    case 1:location="A"; break;
                    case 2:location="B";  break;
                    case 3:location="C";   break;
                }
                for(int j =1;j<=8;++j)
                {
                    classDoorName=location+i+"0"+j;
                    Classroom classroom = new Classroom();
                    classroom.setClassroomDoorId(classDoorName);
                    classroom.setCapacity(capicity);
                    classroom.setTeachingBuilding(building);
                    getSet().add(classroom);
                }
            }
        }
        classroomService.saveBatch(getSet());
    }

    @Test
    public void deleteClassroomById() throws Exception
    {

        classroomService.deleteByProperty("classroomId",7);
    }
    @Test
    public void testAddClassroom()
        throws Exception
    {

    }
}
