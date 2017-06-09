/*
 * Copyright 2017 Software Engineering and Synthesis Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sesygroup.choreography.choreographyspecification.model.action;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.sesygroup.choreography.choreographyspecification.model.Message;
import com.sesygroup.choreography.choreographyspecification.model.Participant;
import com.sesygroup.choreography.choreographyspecification.model.State;
import com.sesygroup.choreography.choreographyspecification.model.action.SendingMessageActionTransition;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class SendingMessageActionTransitionTest {
   private static SendingMessageActionTransition mockedSendingMessageActionTransition;
   private static SendingMessageActionTransition sendingMessageActionTransition;

   @BeforeClass
   public static void setUp() {
      // source state
      Participant participantOne = new Participant("p1");
      Participant participantTwo = new Participant("p2");
      State sourceState = new State("s0");
      State targetState = new State("s1");
      Message message = new Message("message");

      sendingMessageActionTransition
            = new SendingMessageActionTransition(sourceState, targetState, participantOne, participantTwo, message);
      mockedSendingMessageActionTransition = Mockito.mock(SendingMessageActionTransition.class);
      Mockito.when(mockedSendingMessageActionTransition.getSourceParticipant()).thenReturn(participantOne);
      Mockito.when(mockedSendingMessageActionTransition.getTargetParticipant()).thenReturn(participantTwo);
      Mockito.when(mockedSendingMessageActionTransition.getSourceState()).thenReturn(sourceState);
      Mockito.when(mockedSendingMessageActionTransition.getTargetState()).thenReturn(targetState);
      Mockito.when(mockedSendingMessageActionTransition.getMessage()).thenReturn(message);
      Mockito.when(mockedSendingMessageActionTransition.toString()).thenReturn("(s0, p1, message, p2, s1)");
   }

   @Test
   public void testGetSourceState() {
      Assert.assertEquals(mockedSendingMessageActionTransition.getSourceState(),
            sendingMessageActionTransition.getSourceState());
   }

   @Test
   public void testGetTargetState() {
      Assert.assertEquals(mockedSendingMessageActionTransition.getTargetState(),
            sendingMessageActionTransition.getTargetState());
   }

   @Test
   public void testGetSourceParticipant() {
      Assert.assertEquals(mockedSendingMessageActionTransition.getSourceParticipant(),
            sendingMessageActionTransition.getSourceParticipant());
   }

   @Test
   public void testGetTargetParticipant() {
      Assert.assertEquals(mockedSendingMessageActionTransition.getTargetParticipant(),
            sendingMessageActionTransition.getTargetParticipant());
   }

   @Test
   public void testGetMessage() {
      Assert.assertEquals(mockedSendingMessageActionTransition.getMessage(),
            sendingMessageActionTransition.getMessage());
   }

   @Test
   public void testToString() {
      Assert.assertEquals(mockedSendingMessageActionTransition.toString(), sendingMessageActionTransition.toString());
   }
}
