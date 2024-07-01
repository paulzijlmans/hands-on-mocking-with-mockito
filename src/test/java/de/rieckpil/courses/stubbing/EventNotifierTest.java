package de.rieckpil.courses.stubbing;

import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.EventNotifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventNotifierTest {

  @Mock
  private EventNotifier eventNotifier;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @Test
  void voidMethodStubbing() {
//    doThrow(new RuntimeException("Error")).when(eventNotifier).notifyNewUserCreation("duke");
    Mockito
      .doNothing()
      .doThrow(new RuntimeException("test"))
      .when(eventNotifier).notifyNewUserCreation("duke");

    eventNotifier.notifyNewUserCreation("duke");
    assertThrows(RuntimeException.class, () -> eventNotifier.notifyNewUserCreation("duke"));
  }

  @Test
  void doReturnExample() {
//    when(bannedUsersClient.amountOfBannedAccounts()).thenReturn(42);

    doReturn(42).when(bannedUsersClient).amountOfBannedAccounts();

    System.out.println(bannedUsersClient.amountOfBannedAccounts());
  }
}
