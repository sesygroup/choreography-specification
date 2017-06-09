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
package com.sesygroup.choreography.choreographyspecification.model;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;

import com.sesygroup.choreography.choreographyspecification.model.ChoreographySpecification;
import com.sesygroup.choreography.choreographyspecification.model.Message;
import com.sesygroup.choreography.choreographyspecification.model.Participant;
import com.sesygroup.choreography.choreographyspecification.model.State;
import com.sesygroup.choreography.choreographyspecification.model.action.SendingMessageActionTransition;

/**
 *
 * @author Alexander Perucci (http://www.alexanderperucci.com/)
 *
 */
public class ChoreographySpecificationTest {
   private static ChoreographySpecification mockedChoreographySpecification;
   private static ChoreographySpecification choreographySpecification;

   @BeforeClass
   public static void setUp() {
      Participant sourceParticipant = new Participant("sourceParticipant");
      Participant targetParticipant = new Participant("targetParticipant");
      State initialState = new State("initialState");
      State targetState = new State("targetState");
      Message message = new Message("message");
      SendingMessageActionTransition transition = new SendingMessageActionTransition(initialState, targetState,
            sourceParticipant, targetParticipant, message);
      choreographySpecification = new ChoreographySpecification();
      choreographySpecification.getParticipants().add(sourceParticipant);
      choreographySpecification.getParticipants().add(targetParticipant);
      choreographySpecification.getStates().add(initialState);
      choreographySpecification.getStates().add(targetState);
      choreographySpecification.setInitialState(initialState);
      choreographySpecification.getMessages().add(message);
      choreographySpecification.getTransitions().add(transition);

      mockedChoreographySpecification = Mockito.mock(ChoreographySpecification.class);
      Mockito.when(mockedChoreographySpecification.getParticipants())
            .thenReturn(Sets.newSet(sourceParticipant, targetParticipant));
      Mockito.when(mockedChoreographySpecification.getStates()).thenReturn(Sets.newSet(initialState, targetState));
      Mockito.when(mockedChoreographySpecification.getInitialState()).thenReturn(initialState);
      Mockito.when(mockedChoreographySpecification.getMessages()).thenReturn(Sets.newSet(message));
      Mockito.when(mockedChoreographySpecification.getTransitions()).thenReturn(Sets.newSet(transition));
      Mockito.when(mockedChoreographySpecification.validate()).thenReturn(true);
   }

   @Test
   public void testGetStates() {
      Assert.assertEquals(mockedChoreographySpecification.getStates(), choreographySpecification.getStates());
   }

   @Test
   public void testGetInitialState() {
      Assert.assertEquals(mockedChoreographySpecification.getInitialState(),
            choreographySpecification.getInitialState());
   }

   @Test
   public void testGetMessages() {
      Assert.assertEquals(mockedChoreographySpecification.getMessages(), choreographySpecification.getMessages());
   }

   @Test
   public void testGetTransitions() {
      Assert.assertEquals(mockedChoreographySpecification.getTransitions(), choreographySpecification.getTransitions());
   }

   @Test
   public void testValidate() {
      Assert.assertEquals(mockedChoreographySpecification.validate(), choreographySpecification.validate());
   }

   @Test()
   public void testNotValidate() {
      ChoreographySpecification choreographySpecification = new ChoreographySpecification();
      choreographySpecification.getTransitions()
            .add(new SendingMessageActionTransition(new State("initialState"), new State("targetState"),
                  new Participant("sourceParticipant"), new Participant("targetParticipant"),
                  new Message("outputMessage")));
      Assert.assertFalse(choreographySpecification.validate());
   }

   @Test()
   public void testValidateEmptyChoreographySpecification() {
      Assert.assertTrue(new ChoreographySpecification().validate());

   }

}
